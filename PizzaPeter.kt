class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
): PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
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
    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}