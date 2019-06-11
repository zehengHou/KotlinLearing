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


fun main() {
    //m1(1, 1)
    val setTest = SetTest()
    setTest.num = 10
    println(setTest.num)
}