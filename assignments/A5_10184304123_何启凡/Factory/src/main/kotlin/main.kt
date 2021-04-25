fun main(args: Array<String>) {
    val car1: Car = CarFactory.getCar(CarType.TESLA)
    val car2: Car = CarFactory.getCar(CarType.BMW)
    println(car1.getDescription())
    println(car2.getDescription())
}