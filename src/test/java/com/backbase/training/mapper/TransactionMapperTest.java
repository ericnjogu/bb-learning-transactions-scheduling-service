package com.backbase.training.mapper;

import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionsPostRequestBody;
import com.backbase.training.beans.Transaction;
import com.backbase.training.beans.Transactions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionMapperTest {
  private TransactionMapper transactionMapper;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    transactionMapper = Mappers.getMapper(TransactionMapper.class);
    objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Test
  void mapTransaction() throws IOException {
    //@formatter:off
    Transactions transactions = objectMapper.readValue(
        IOUtils.resourceToString("/json/response/opb-transactions.json", StandardCharsets.UTF_8),
        Transactions.class
    );
    //@formatter:on
    assertEquals(1, transactions.getTransactions().size());
    TransactionsPostRequestBody dbsTxReq = transactionMapper.map(transactions.getTransactions().get(0));
    assertEquals("this is for family", dbsTxReq.getDescription());
  }
}