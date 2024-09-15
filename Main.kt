import kotlin.system.exitProcess
fun main() {
    val pizzaPeter = PizzaPeter(170.0, 145.3, 188.9, 160.0)
    val pizzaMoscow = PizzaMoscow(178.5, 165.7, 218.2, 199.0)

    
    var currentPizzaCity:PizzaCity

    while (true) 
    {
        println("Добрый день! Выберете город")
        println("1. Москва\n2. Санкт-Петербург \n0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1. Неаполитанская\n2. Римская \n3. Сицилийская\n4. Тирольская \n0. Показать статистику")

        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "0" -> currentPizzaCity.showStatistics()
        else -> {
        println("ERROR")
        exitProcess(1)
    }
}
}

fun selectAddService(currentPizzaCity: PizzaCity) {
    when(currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
    }
}