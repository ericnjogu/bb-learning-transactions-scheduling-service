package com.backbase.training.scheduler;

import com.backbase.presentation.transaction.listener.client.v2.transactions.PresentationTransactionTransactionsClient;
import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionsPostRequestBody;
import com.backbase.training.beans.Transactions;
import com.backbase.training.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledTask {
  private static final int ONE_HOUR = 36_000_000;
  private static final int THREE_SECONDS = 3_000;

  private final RestTemplate restTemplate = new RestTemplateBuilder().build();
  private final TransactionMapper transactionMapper;
  private final PresentationTransactionTransactionsClient transactionsClient;

  @Value("${openbankproject.transactions.url}")
  private String url;

  @Scheduled(fixedRate = ONE_HOUR, initialDelay = THREE_SECONDS)
  public void createTransactions() {
    log.info("scheduler triggered, starting transaction ingestion");
    transactionsClient.postTransactions(getTransactions());
  }

  private List<TransactionsPostRequestBody> getTransactions() {
    Transactions transactions = restTemplate.getForEntity(url, Transactions.class).getBody();
    if (Objects.nonNull(transactions) && Objects.nonNull(transactions.getTransactions())) {
      log.debug("opb transactions received: {}", transactions.getTransactions().size());

      return transactions.getTransactions().stream().map(transactionMapper::map).collect(Collectors.toList());
    } else {
      log.debug("opb transactions are null");
      return Collections.emptyList();
    }
  }
}
