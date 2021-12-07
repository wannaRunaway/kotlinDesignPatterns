//java 5种单例模式
public class SingleInstance {

    //加载时创建单例
    static class SingleInstanceAdd {
        private SingleInstanceAdd() {
        }

        private static SingleInstanceAdd instanceAdd = new SingleInstanceAdd();

        public static SingleInstanceAdd getInstance() {
            return instanceAdd;
        }

        @Override
        public String toString() {
            return super.toString() + " add completed";
        }
    }

    //懒加载
    static class SingleInstanceLazy {
        private SingleInstanceLazy() {
        }

        private static SingleInstanceLazy singleInstanceLazy = null;

        public static SingleInstanceLazy getInstance() {
            if (singleInstanceLazy == null) {
                singleInstanceLazy = new SingleInstanceLazy();
            }
            return singleInstanceLazy;
        }

        @Override
        public String toString() {
            return super.toString() + " lazy complete";
        }
    }

    //同步锁写法
    static class SingleInstanceSynchronized {
        private SingleInstanceSynchronized() {
        }

        private static SingleInstanceSynchronized singleInstanceSynchronized = null;

        public static synchronized SingleInstanceSynchronized getInstance() {
            if (singleInstanceSynchronized == null) {
                singleInstanceSynchronized = new SingleInstanceSynchronized();
            }
            return singleInstanceSynchronized;
        }
    }

    //dcl
    static class SingleInstanceDCL {
        private SingleInstanceDCL() {
        }

        private static SingleInstanceDCL singleInstanceDCL = null;

        public static SingleInstanceDCL getInstance() {
            if (singleInstanceDCL == null) {
                synchronized (SingleInstanceDCL.class) {
                    if (singleInstanceDCL == null) singleInstanceDCL = new SingleInstanceDCL();
                }
            }
            return singleInstanceDCL;
        }
    }

    //静态内部类写法
    static class SingleInstanceStatic{
        private SingleInstanceStatic(){}
        private static class SingleStatic{
            private static SingleInstanceStatic singleInstanceStatic = new SingleInstanceStatic();
        }
        public SingleInstanceStatic getInstance(){
            return SingleStatic.singleInstanceStatic;
        }
    }

    public static void main(String[] args) {
        print(SingleInstanceAdd.getInstance().toString());
        print(SingleInstanceLazy.getInstance().toString());
    }

    static void print(String message) {
        System.out.println(message);
    }
}
