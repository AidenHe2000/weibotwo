object CarFactory {
    fun getCar(carType: CarType): Car {
        return when (carType) {
            CarType.BMW -> BMW()
            CarType.FORD -> Ford()
            CarType.TESLA -> Tesla()
        }
    }
}