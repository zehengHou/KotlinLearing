package com.navoo.kotlin.kt


/*带有两个 Int 参数、返回 Int 的函数*/
fun m1(x: Int, y: Int): Int {
    return x + y
}

/*定义只读局部变量使用关键字 val 定义,只能为其赋值一次*/
fun vall(): Unit {
    val a: Int = 1 // 立即赋值
    val b = 2 // 自动推断出 `Int` 类型
    val c: Int // 如果没有初始值类型不能省略
    c = 3 // 明确赋值
}

/*可重新赋值的变量使用 var 关键字*/
fun varr(): Unit {
    var x = 5
    x += 1
}

/**
 * 属性和字段
 */
/*Kotlin 类中的属性既可以用关键字 var 声明为可变的，也可以用关键字 val 声明为只读的*/
class Address {
    var name: String = "name"
    var street: String = "street"
    var city = "city"
    var state: String? = "state"
    var zip: String = "zip"

}


fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street
    result.city = address.city
    result.state = address.state
    result.zip = address.zip
    return result
}
/*Getters 与 Setters*/
/**
 * 声明一个属性的完整语法是
 * 其初始器（initializer）、getter 和 setter 都是可选的。属性类型如果可以从初始器 （或者从
 * 其 getter 返回值，如下文所示）中推断出来，也可以省略
 * var <propertyName>[: <PropertyType>] [= <property_initializer>]
 *      [<getter>]
 *     [<setter>]
 */
/*我们可以为属性定义自定义的访问器。如果我们定义了一个自定义的 getter，那么每次访问该
属性时都会调用它 （这让我们可以实现计算出的属性）。以下是一个自定义 getter 的示例：*/
class SetTest {
    var num: Int = -1
        get() = field + 1
        set(value) {
            field = value + 100
            println("set invoke...$field")
        }

    var setterVisibility: Int = -1
        private set
}

/*幕后字段:在 Kotlin 类中不能直接声明字段。然而，当一个属性需要一个幕后字段时，Kotlin 会自动提
  供。这个幕后字段可以使用 field 标识符在访问器中引用：*/
var counter = 0 // 注意：这个初始器直接为幕后字段赋值
    set(value) {
        if (value >= 0) field = value
    }

/*幕后属性:如果你的需求不符合这套“隐式的幕后字段”方案，那么总可以使用 幕后属性（backing property）：*/

private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // 类型参数已推断出
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

/** 编译期常量 */
/*编译期常量
    已知值的属性可以使用 const 修饰符标记为 编译期常量。 这些属性需要满足以下要求：
    位于顶层或者是 object 声明 或 companion object 的一个成员
    以 String 或原生类型值初始化
    没有自定义 getter
    这些属性可以用在注解中
*/
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {
}

/**延迟初始化属性与变量*/
public class MyTest() {
    lateinit var lateInit: LateInit
    lateinit var str: String
    fun setUp() {
        lateInit = LateInit()
        //str=""
    }

    fun test() {
        lateInit.m()
        str.toString()

    }


    class LateInit {
        fun m() {

        }
    }
}

/**该修饰符只能用于在类体中的属性（不是在主构造函数中声明的 var 属性，并且仅当该属性
没有自定义 getter 或 setter 时）*//*而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或
变量必须为非空类型，并且不能是原生类型。
在初始化前访问一个 lateinit 属性会抛出一个特定异常，该异常明确标识该属性被访问及
它没有初始化的事实。
检测一个 lateinit var 是否已初始化（自 1.2 起）
要检测一个 lateinit var 是否已经初始化过，请在该属性的引用上使用 .isInitialized ：
if (foo::bar.isInitialized) {
println(foo.bar)
}
此检测仅对可词法级访问的属性可用，即声明位于同一个类型内、位于其中一个外围类型中
或者位于相同文件的顶层的属性。*/


/**可见性修饰符:类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。 （getter
总是与属性有着相同的可见性。） 在 Kotlin 中有这四个可见性修饰符： private 、
protected 、 internal 和 public 。 如果没有显式指定修饰符的话，默认可见性是
public */


val x = 1
var y: Int = 0

/**扩展*/


fun main() {
    //m1(1, 1)
    val setTest = SetTest()
    setTest.num = 10
    println(setTest.num)
    /* println(::lateInit.isLateinit)
     println(::str.isLateinit)*/
    /**
     * 属性引用
     */
    println(::x.get())
    println(::x.name)


    ::y.set(1)
    println(y)
}

