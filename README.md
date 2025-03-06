# Store Management System API
## Advanced Coding Assignment-8

### Problem Statement
You have been provided with a RESTful web service for a **Store Management System** using Spring Boot. The API allow users to manage products, including adding, updating, deleting, and retrieving products. The system store the product data in a Postgres database.

You are tasked with creating endpoints to support search and filter opeartions to allow users to efficiently find products based on various criteria (e.g., name, category, price range, stock quantity range) along with Validation, Pagination, and Sorting features.

### Steps to Follow
1. This GitHub repository will be accessible to you once you accept the Assignment.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below: (showing major files only)
   ```
   root
   ├── pom.xml
   └── src/main
       ├── java/com/mystore/app
       |   ├── config
       |   |   ├── MyGlobalExceptionHandler.java
       |   |   └── OASConfig.java
       |   ├── entity
       |   |   └── Product.java
       |   ├── repositories
       |   |   └── ProductRepository.java
       |   ├── rest
       |   |   └── ProductController.java
       |   ├── service
       |   |   └── ProductService.java
       |   └── AppApplication.java
       └── resources
           ├── static
           |   └── index.html
           └── application.properties
   ```

4. Review the code/comments present in above files to understand the structure.
5. Implement the missing classes/methods marked with **TODO** comments.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
7. Once done, push your changes from your system to this remote GitHub repository.

### Files to Work On
- `src/main/java/com/mystore/app/entity/Product.java`
- `src/main/java/com/mystore/app/repositories/ProductRepository.java`
- `src/main/java/com/mystore/app/config/MyGlobalExceptionHandler.java`
- `src/main/java/com/mystore/app/service/ProductService.java`
- `src/main/java/com/mystore/app/rest/ProductController.java`

### Starter Code Files:
Starter code for below functionalities have already provided:
1. **Spring Boot application:**
   - Use Spring Boot to set up the application.
   - Use `Spring Web` dependency to create the RESTful APIs.
   - A Postgres database is already configured to store products' data. The provided `application.properties` file contains the related details like - database location, database name, username, and password.

2. **Product Entity:**
   A `Product` class is already provided with the following fields:
   - `id` (Integer, Unique Identifier for the Product)
   - `name` (String, Not Null)
   - `category` (String, Not Null, e.g., "Electronics", "Clothing", etc.)
   - `price` (Double, Not Null, must be a positive value)
   - `stockQuantity` (Integer, Not Null, must be a non-negative value)

3. **REST Endpoints:** Implementation provided for the following REST endpoints for managing the products:
   - **Create a new product:** `POST /products`
     - Request Body: JSON object with fields `name`, `category`, `price` and `stockQuantity`.
     - Response: JSON object with the newly created product details, including the generated `id`.
   - **Get all products:** `GET /products`
     - Response: A list of all products in JSON format.
   - **Get a product by ID:** `GET /products/{id}`
     - Response: A JSON object of a single product, or `404 Not Found` if the product doesn't exist.
   - **Update product details:** `PUT /products/{id}`
     - Request Body: JSON object with updated fields `name`, `category`, `price`, `stockQuantity`.
     - Response: The updated product details, or `404 Not Found` if the product doesn't exist.
   - **Delete a product:** `DELETE /products/{id}`
     - Response: `204 No Content` if the product is deleted successfully, or `404 Not Found` if the product doesn't exist.


## Requirements:
1. **Validation**
   
   Update the files to include below data validations to check while adding new products:
     - `name`: not null, not blank, not empty
     - `category`: not null, not blank, not empty
     - `price`: positive, minimum = 100, maximum = 50000
        - If price < 100, show: `"Please don't add any product with price lesser than 100"`
        - If price > 50000, show: `"This platform doesn't allow high priced products. Prices must be <= 50000"`
     - `stockQuantity`: positive, minimum = 10, maximum = 500

2. **Search and Filter Products using JPA repository:** Implement search and filter endpoints to allow users to find products based on various criteria:
   - **Search products by name:** `GET /products/search`
     - Query Parameters:
       - `name`: The name of the product to search for (e.g., `name=phone`).
     - Response: A list of products that match the search term in the name field (case-insensitive).
   - **Filter products by category:** `GET /products/filter/category`
     - Query Parameters:
       - `category`: The category to filter products by (e.g., `category=Electronics`).
     - Response: A list of products that belong to the specified category.
   - **Filter products by price range:** `GET /products/filter/price`
     - Query Parameters:
       - `minPrice`: The minimum price (e.g., `minPrice=10`).
       - `maxPrice`: The maximum price (e.g., `maxPrice=100`).
     - Response: A list of products whose price falls within the specified range.
   - **Filter products by stock quantity:** `GET /products/filter/stock`
     - Query Parameters:
       - `minStock`: The minimum stock quantity (e.g., `minStock=10`).
       - `maxStock`: The maximum stock quantity (e.g., `maxStock=100`).4
     - Response: A list of products whose stock quantity is within the specified range.

3. **Pagination and Sorting**

   Update the `GET /products` endpoint to enable pagination and sorting. For example `GET /products?page=0&pageSize=3&sortBy=price&sortDir=desc`
   
   Perform sorting based on the field name and direction provided.


## Submission Requirements:
Implement the required API endpoints for the provided Spring Boot application. You can use Postman or cURL commands to test your API endpoints.

After completing the assignment and developing the solution code in your system, commit and push the changes to this repository. 
  - Stage your changes and commit the files:
    ```
    git add .
    git commit -m "Completed the assignment"
    ```
  - Push your changes to the GitHub repository:
    ```
    git push
    ```

## Grading Criteria:
- To implement validation correctly and showing the custom message when price value is not in the provided range [3 Marks]
- To implement search by name endpoint correctly [1 Mark]
- To implement filter by category endpoint correctly [1 Mark]
- To implement filter by price endpoint correctly [1 Mark]
- To implement filter by stock quantity endpoint correctly [1 Mark]
- To implement pagination correctly [1 Mark]
- To implement sorting correctly [2 Mark]

Good luck, and happy coding!
