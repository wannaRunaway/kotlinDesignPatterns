import java.util.*
import kotlin.collections.ArrayList

//observe pattern: observe observable subscribe
//抽象一个观察者接口，实现了他的类都可以当作观察者
interface Observer {
    //接受被观察者的信息
    fun update(observable: Observable, objects: Any)
}

open class Observable {
    //存储所有的观察者对象
    private var list: ArrayList<Observer> = ArrayList<Observer>()

    //添加观察者对象
    fun addObserver(observe: Observer) {
        observe?.apply {
            list.add(observe)
        }
    }

    //移除观察者
    fun deleteObserver(observe: Observer) {
        list?.apply {
            if (list.size > 0) {
                list.remove(observe)
            }
        }
    }

    //有活动行为通知观察者
    fun notifyObservers(obj: Any) {
        for (element in list) {
            element.update(this, obj)
        }
    }
}

//观察者
class FishMan(var name: String) : Observer {
    override fun update(observable: Observable, objects: Any) {
        println("$name observed this fish is eating $objects")
    }
}

class Shark(var name: String) : Observer {
    override fun update(observable: Observable, objects: Any) {
        println("$name observed this fish is eating $objects")
    }
}

//被观察者
class Fish(var name: String) : Observable() {

    fun eating(food: String) {
        notifyObservers(food)
    }

    fun toStrings(): String {
        return "Fish"
    }
}

fun main() {
    println("hi is me")
    var fish = Fish("smallFish")
    var fishManJack = FishMan("Jack")
    var fishManTonny = FishMan("Tonny")
    var fishManMash = FishMan("Mash")
    var shark = Shark("Onil")
    fish.addObserver(fishManJack)
    fish.addObserver(fishManTonny)
    fish.addObserver(fishManMash)
    fish.addObserver(shark)
    fish.deleteObserver(fishManJack)
    fish.eating("smallFish")
}