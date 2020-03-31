package dev.neyerdavid.webfluxstockquoteservice.service;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import dev.neyerdavid.webfluxstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

public class QuoteGeneratorServiceImplTest {
    QuoteGeneratorServiceImpl quoteGeneratorService = new QuoteGeneratorServiceImpl();

    @Before
    public void setUp()throws Exception {

    }

    @Test
    public void fetchQuoteStreamCountDown() throws Exception {

        Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100L));
        Consumer<Quote> println = System.out::println;
        Consumer<Throwable> errorHandler = e -> System.out.println("Some Error Occurred");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable allDone = () -> countDownLatch.countDown();

        quoteFlux.take(10)
            .subscribe(println, errorHandler, allDone);
        countDownLatch.await();

    }

}
