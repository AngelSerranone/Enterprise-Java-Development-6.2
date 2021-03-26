## Requirements

Using Eureka and Rest Templates complete the following:

1. Book Look Up:

   - A simple BookService that stores Books by isbn and includes title, author, and genre
   - A simple BookFormatService that stores Books by isbn and includes all formats in which the Book is available (hardcover, paperback, electronic, and/or audio).

   Both services should have standard GET and POST routes. The Book service should return a dto with isbn, title, author, genre, and a list of available formats. The formats must be retrieved from the BookFormatService.

2. E-Commerce App:

   - A simple service that stores Products with id, name, price, and inventoryCount
   - A simple service that stores ShippingOrders with product_id and quantity

   Both services should have standard GET and POST routes. When a new Order is posted to the ShippingOrdersService, a new order should be created and the inventoryCount should be decremented through the ProductService.