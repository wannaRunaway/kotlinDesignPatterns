//抽象工厂模式
private interface Background{
    fun drawBackground()
}

private interface Border{
    fun drawBorder()
}

private interface AdsShape{
    fun draw()
}

private interface AbsThemeFactory{
    fun createBackground():Background
    fun createBorder():Border
}

private class DarkBackground : Background{
    override fun drawBackground() {
        println("draw ${Thread.currentThread().stackTrace[1].methodName}")
    }
}

private class DarkBorder : Border{
    override fun drawBorder() {
        println("draw ${Thread.currentThread().stackTrace[1].methodName}")
    }
}

private class AbScrollbar(var absThemeFactory: AbsThemeFactory): AdsShape{
    override fun draw() {
        absThemeFactory.createBackground().drawBackground()
        absThemeFactory.createBorder().drawBorder()
    }
}

private class AbsDarkThemeFactory : AbsThemeFactory{
    override fun createBackground(): Background {
        return DarkBackground()
    }

    override fun createBorder(): Border {
        return DarkBorder()
    }
}

fun main(){
    AbScrollbar(AbsDarkThemeFactory()).draw()
}
