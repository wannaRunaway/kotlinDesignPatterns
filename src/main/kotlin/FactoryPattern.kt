//一般工厂模式，将选择工厂抽象
private interface IViewDraw {
    fun onDraw()
}

private class Theme(var name: String) {
    @JvmName("getName1")
    fun getName(): String {
        return name
    }
}

private interface ThemeFactory {
    fun createTheme(): Theme
}

private class Scrollbar(var themeFactory: ThemeFactory) : IViewDraw {
    override fun onDraw() {
        println(javaClass.name + " is " + Thread.currentThread().stackTrace[1].methodName + " ${themeFactory.createTheme().name}")
    }
}

private class DarkThemeFactory : ThemeFactory {
    override fun createTheme(): Theme {
        return Theme("DarkTheme")
    }
}

private class LightThemeFactory : ThemeFactory {
    override fun createTheme(): Theme {
        return Theme("LightTheme")
    }
}

fun main() {
    val themeFactory = DarkThemeFactory()
    val scrollbar = Scrollbar(themeFactory)
    scrollbar.onDraw()
    val lightThemeFactory = LightThemeFactory()
    val lightScrollbar = Scrollbar(lightThemeFactory)
    lightScrollbar.onDraw()
}

