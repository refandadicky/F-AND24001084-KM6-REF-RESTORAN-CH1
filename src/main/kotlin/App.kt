import model.menu
import source.MenuDataSource
import source.MenuDataSourceImpl
import java.lang.NumberFormatException

class App {
    private val menuData = MenuDataSourceImpl().getMenuList()
    private var selectMenu: menu? = null
    private var selectedArgument: String? = null

    fun printHeader() {
        println("================================")
        println("           List Menu            ")
        println("================================")
        menuData.forEachIndexed { index, data ->
            println(" ${index + 1}.${data.menuName}\t= Rp. ${data.menuPrice}/porsi")
        }// lambada fuction
        println("================================")
    }

    fun getSelectedMenu() {
        println(" What do you want to buy ? 1/2/3/4/5")
        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1..menuData.size) {
                selectMenu = menuData[selectedIndex - 1]
                println("\n")
                println("================================")
                println(" Kamu memilih Menu $selectedIndex")
                println(" Nama Menu \t= ${selectMenu?.menuName}")
                println(" Harga     \t= Rp. ${selectMenu?.menuPrice}")
                println("================================")
                getPayment(menuData[selectedIndex - 1].menuPrice)
                printMethod()
            } else {
                println(" You input wrong value")
                getSelectedMenu()
            }
        } catch (e: NumberFormatException) {
            println(" You input wrong value")
            getSelectedMenu()
        }
        println(" Apakah Anda ingin membeli lagi ? Y/N")
        selectedArgument = readln().toString()
    }

    fun min(a:Int, b:Int): Int{
        return a - b
    }

    fun getPayment(price: Int){
        println(" Enter payment :")
        try {
            val payment = readln().toInt()
            if (payment>=price){
                println(" Terima kasih, Anda berhasil memesan makanan")
                println(" Uang Kembalian Anda Rp. " +min(payment,price) )
            }else{
                println(" Maaf, pembayaran Anda gagal!")
                getPayment(price)
            }
        }catch (e: NumberFormatException) {
            println(" You input wrong value")
            getPayment(price)
        }
    }

    fun printMethod() {
        println("\n")
        println("================================")
        println("   Metode Pengiriman Makanan    ")
        println("================================")
        println(" 1. Take Away")
        println(" 2. Delivery")
        println("================================")
        getMethod()
    }

    fun getMethod(){
        println(" Pilih methode pengiriman Anda ? 1/2")
        try {
            val selectedmethod = readln().toInt()
            println("\n")
            if (selectedmethod == 1) {
                println(" Makananmu sedang dimasak (5 detik) .....")
                Thread.sleep(5000)
                println(" Makananmu sudah siap! Silahkan ambil di resto ya! (5 detik) .....")
                Thread.sleep(5000)
                println(" Pesanan selesai! (3 detik) .....")
                Thread.sleep(3000)
            }
            else if (selectedmethod == 2) {
                println(" Makananmu sedang dimasak (5 detik) .....")
                Thread.sleep(5000)
                println(" Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) .....")
                Thread.sleep(5000)
                println(" Driver sampai! Pesanan selesai! (3 detik) .....")
                Thread.sleep(3000)
            } else {
                println("You input wrong value")
                getMethod()
            }
        } catch (e: NumberFormatException) {
            println("You input wrong value")
            getMethod()
        }
    }

    fun run(){
        do {
            printHeader()
            getSelectedMenu()
        } while (selectedArgument.equals("Y") || selectedArgument.equals("y"))
        println("Program selesai")
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}