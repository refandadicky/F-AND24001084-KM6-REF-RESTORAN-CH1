package source

import model.menu

interface MenuDataSource{
    fun getMenuList() : List<menu>
}

class MenuDataSourceImpl() : MenuDataSource{
    override fun getMenuList(): List<menu> {
        return listOf(
            menu(
                menuName = "Ayam Bakar",
                menuPrice = 50000
            ),
            menu(
                menuName = "Ayam Goreng",
                menuPrice = 40000
            ),
            menu(
                menuName = "Ayam Geprek",
                menuPrice = 40000
            ),
            menu(
                menuName = "Kulit Ayam Crispy",
                menuPrice = 15000
            ),
            menu(
                menuName = "Sate Usus Ayam",
                menuPrice = 5000
            ),
        )
    }

}