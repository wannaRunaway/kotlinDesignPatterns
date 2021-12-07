import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.concurrent.thread

//JDK动态代理
private interface JDKISubject {
    fun init() {
        println("${javaClass.name} init")
    }

    fun doAction() {
        println("${javaClass.name} doAction")
    }
}

private class JDKRealSubject1 : JDKISubject {
    override fun init() {
        println("${javaClass.name} init")
    }

    override fun doAction() {
        println("${javaClass.name} doAction")
    }
}

private class JDKRealSubject2 : JDKISubject {
    override fun init() {
        super.init()
        println("${javaClass.name} init")
    }

    override fun doAction() {
        super.doAction()
        println("${javaClass.name} doAction")
    }
}

//动态代理类
private class SubjectProxyHandle(var subject: Any) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        println("${javaClass.name} start")
        var result: Any = method?.invoke(subject, args)!!
        println("${javaClass.name} end")
        return result
    }
}

fun main(){

}