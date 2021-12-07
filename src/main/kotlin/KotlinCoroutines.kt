import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//fun main() = runBlocking {
////    launch {
////        dowork()
////    }
////    print("Hello ")
////    doWorld();
////    print("Done")
//    repeat(100_000){
//        launch {
//            delay(5000)
//            print("*")
//        }
//    }
//}

fun main(){
    repeat(100_000){
        thread {
            Thread.sleep(5000)
            print("*")
        }
    }
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000)
        print("World")
    }
    launch {
        delay(1000)
        print("World1")
    }
    val myjob = launch {
        delay(3000)
        print("job Done")
    }
    print("Hello ")
}

fun startCoroutine() {

}

suspend fun dowork() {
    delay(2000)
    print("World")
}