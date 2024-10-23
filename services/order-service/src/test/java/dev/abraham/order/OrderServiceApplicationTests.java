package dev.abraham.order;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {
	@ServiceConnection
	static MySQLContainer mySQLContainer=new MySQLContainer("mysql");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void createOrder() {
		String order= """
				{
				  "skuCode": "ABC123",
				  "price": 19.99,
				  "quantity": 5
				}
				
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(order)
				.when()
				.post("/api/v1/order")
				.then()
				.statusCode(200)
				.body(Matchers.notNullValue());
	}
}
