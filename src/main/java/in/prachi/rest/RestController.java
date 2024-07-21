package in.prachi.rest;

import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDb", name="prachi")
	public String getData() {
		System.out.println("redis method called");
		int i= 10/0;
		return "redis data sent to your email";
	}
	public String getDataFromDb() {
		System.out.println("db method called");
		return "DB data sent to your email";
	}
}
