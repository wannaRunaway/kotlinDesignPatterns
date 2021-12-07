//kotlin中的动态代理，使用by关键字。效率比java反射高很多
interface ProxyKotlinPatternInterface {
    fun doAction()
}

class ProxyKotlinPatternSubject : ProxyKotlinPatternInterface {
    override fun doAction() {
        println("${javaClass.name}  ${Thread.currentThread().stackTrace[1].methodName}")
    }
}

class ProxyKotlinPatternExecute(proxyKotlinPatternInterface: ProxyKotlinPatternInterface) : ProxyKotlinPatternInterface by proxyKotlinPatternInterface{
    fun execute(){
        println("${javaClass.name}  ${Thread.currentThread().stackTrace[1].methodName}")
    }
}

fun main(){
    val proxyKotlinPatternExecute = ProxyKotlinPatternExecute(ProxyKotlinPatternSubject())
    proxyKotlinPatternExecute.execute()
    proxyKotlinPatternExecute.doAction()
}