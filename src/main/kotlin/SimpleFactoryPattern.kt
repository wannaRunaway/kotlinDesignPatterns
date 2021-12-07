//简单工厂模式，对象切换在静态方法完成
interface SimpleFactoryDraw{
    fun draw()
}

private class Circle: SimpleFactoryDraw{
    override fun draw() {
        println(javaClass.name+ " isinvoking " + Thread.currentThread().stackTrace[1].methodName)
    }
}

private class Shape: SimpleFactoryDraw{
    override fun draw() {
        println(javaClass.name+ " isinvoking " + Thread.currentThread().stackTrace[1].methodName)
    }
}

private class Rectangle: SimpleFactoryDraw{
    override fun draw() {
        println(javaClass.name+ " isinvoking " + Thread.currentThread().stackTrace[1].methodName)
    }
}

fun getShape(shape: String): SimpleFactoryDraw {
    return when(shape){
        "Circle" -> Circle()
        "Rectangle" -> Rectangle()
        else -> Shape()
    }
}

fun main(){
    var circle:SimpleFactoryDraw = getShape("Circle")
    var rectangle:SimpleFactoryDraw = getShape("rectangle")
    circle.draw()
    rectangle.draw()
}