abstract class PizzaCity(
    protected val neapolitanPizzaPrice: Double, protected val romanPizzaPrice: Double,
    protected val sicilianPizzaPrice: Double, protected val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var checkPhotosCount = 0
    var totalDiscountAmount = 0.0
    var coffeeSoldCount = 0
    var totalCoffeeRevenue = 0.0

    var neapolitanPizzaCoffeeCount = 0
    var romanPizzaCoffeeCount = 0
    var sicilianPizzaCoffeeCount = 0
    var tyroleanPizzaCoffeeCount = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showStatistics() {
        // Общая статистика по пицце
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        // Учет проданного кофе
        if (this is Drink) {
            println("Количество проданного кофе: $coffeeSoldCount")
            println("Выручка за кофе: $totalCoffeeRevenue")
            showCoffeeStatistics()
            println(showPizzaCoffeeStatistics());
        }

        if (this is CheckPhoto) {
            showCheckPhotoStatistics()
        }

        // Учет проданных соусов
        if (this is PizzaKazan) {
            println("Количество проданных соусов: $sauceCount")
            println("Выручка за соусы: $sauceRevenue")
        }

        // Подсчет общей выручки с учетом всех услуг
        val pizzaRevenue = neapolitanPizzaCount * neapolitanPizzaPrice +
                           romanPizzaCount * romanPizzaPrice +
                           sicilianPizzaCount * sicilianPizzaPrice +
                           tyroleanPizzaCount * tyroleanPizzaPrice

        val totalRevenue = pizzaRevenue + (if (this is Drink) totalCoffeeRevenue else 0.0) +
                           (if (this is PizzaKazan) sauceRevenue else 0.0) - totalDiscountAmount

        println("Всего заработано денег (с учетом всех доп. услуг): $totalRevenue")
    }

    fun showCheckPhotoStatistics() {
        val totalSales = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val checkPhotoPercentage = if (totalSales > 0) (checkPhotosCount.toDouble() / totalSales) * 100 else 0.0
        return println("Процент людей, показывающих фотографию чека: $checkPhotoPercentage%")
    }

    fun showCoffeeStatistics() {
        val totalSales = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val coffeePercentage = if (totalSales > 0) (coffeeSoldCount.toDouble() / totalSales) * 100 else 0.0
        return println("Процент людей, покупающих кофе: $coffeePercentage%")
    }

    fun showPizzaCoffeeStatistics(): String {
        val totalCoffeeSales = neapolitanPizzaCoffeeCount + romanPizzaCoffeeCount + sicilianPizzaCoffeeCount + tyroleanPizzaCoffeeCount
        var res = ""
    
        res += "Продано кофе с неаполитанской пиццей: $neapolitanPizzaCoffeeCount (${if (neapolitanPizzaCount > 0) (neapolitanPizzaCoffeeCount.toDouble() / neapolitanPizzaCount) * 100 else 0.0}%)\n"
        res += "Продано кофе с римской пиццей: $romanPizzaCoffeeCount (${if (romanPizzaCount > 0) (romanPizzaCoffeeCount.toDouble() / romanPizzaCount) * 100 else 0.0}%)\n"
        res += "Продано кофе с сицилийской пиццей: $sicilianPizzaCoffeeCount (${if (sicilianPizzaCount > 0) (sicilianPizzaCoffeeCount.toDouble() / sicilianPizzaCount) * 100 else 0.0}%)\n"
        res += "Продано кофе с тирольской пиццей: $tyroleanPizzaCoffeeCount (${if (tyroleanPizzaCount > 0) (tyroleanPizzaCoffeeCount.toDouble() / tyroleanPizzaCount) * 100 else 0.0}%)\n"
    
        return res
    }
    
}
