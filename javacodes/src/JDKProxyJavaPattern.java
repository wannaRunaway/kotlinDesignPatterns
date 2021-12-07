import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyJavaPattern {

    //动态代理
    private interface Isubject {
        void init();

        void doAction();
    }

    public static class ProxySubject1 implements Isubject {

        @Override
        public void init() {
            print(getClass().getName() + " init");
        }

        @Override
        public void doAction() {
            print(getClass().getName() + " doAction");
        }
    }

    public static class ProxySubject2 implements Isubject {
        @Override
        public void init() {
            print(getClass().getName() + " init");
        }

        @Override
        public void doAction() {
            print(getClass().getName() + " doAction");
        }
    }

    private static class ProxyHandle implements InvocationHandler {
        private Object subject;

        public ProxyHandle(Object subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            print(getClass().getName() + " start");
            Object result = method.invoke(subject, args);
            print(getClass().getName() + " end");
            return result;
        }
    }

    public static void main(String[] args) {
        Isubject isubject1 = (Isubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{Isubject.class}, new ProxyHandle(new ProxySubject1()));
        isubject1.init();
        isubject1.doAction();
        Isubject isubject2 = (Isubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{Isubject.class}, new ProxyHandle(new ProxySubject2()));
        isubject2.init();
        isubject2.doAction();
    }

    static void print(String message) {
        System.out.println(message);
    }

}
