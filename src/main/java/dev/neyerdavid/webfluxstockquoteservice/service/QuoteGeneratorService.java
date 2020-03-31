package dev.neyerdavid.webfluxstockquoteservice.service;

import java.time.Duration;

import dev.neyerdavid.webfluxstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
