class PizzaKazan(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
): PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice,
), CheckPhoto, Drink {
    var sauceCount = 0
    var sauceRevenue = 0.0
    var saucePrice = 30.0  // Цена за соус

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Казани")
        offerSauce()
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Казани")
        offerSauce()
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Казани")
        offerSauce()
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Казани")
        offerSauce()
    }

    private fun offerSauce() {
        println("Вы хотите добавить соус? (1. Да, 2. Нет)")
        if (readln() == "1") {
            sauceCount++
            sauceRevenue += saucePrice
            println("Соус добавлен за $saucePrice рублей")
        }
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if(readln() == "1") {
            checkPhotosCount++
            totalDiscountAmount += 50
            println("Вам будет скидка 50 рублей с покупки")
        }
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if(readln() == "1") {
            coffeeSoldCount++
            totalCoffeeRevenue += 200
            println("С вас 200 рублей")
            when {
                neapolitanPizzaCount > 0 && neapolitanPizzaCount == coffeeSoldCount -> neapolitanPizzaCoffeeCount++
                romanPizzaCount > 0 && romanPizzaCount == coffeeSoldCount -> romanPizzaCoffeeCount++
                sicilianPizzaCount > 0 && sicilianPizzaCount == coffeeSoldCount -> sicilianPizzaCoffeeCount++
                tyroleanPizzaCount > 0 && tyroleanPizzaCount == coffeeSoldCount -> tyroleanPizzaCoffeeCount++
            }
        }
    }
}
