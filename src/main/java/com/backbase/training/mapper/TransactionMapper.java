package com.backbase.training.mapper;

import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionsPostRequestBody;
import com.backbase.training.beans.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
  @Mapping(target = "externalId", source = "id")
  // from arrangement table
  @Mapping(target = "arrangementId", constant = "f7be27b6-5acb-4df1-9931-2db189804706")
  @Mapping(target = "externalArrangementId", constant = "A03")
  @Mapping(target = "reference", source = "thisAccount.number")
  @Mapping(target = "description", source = "details.description", defaultValue = "Gift")
  @Mapping(target = "typeGroup", constant = "Payment")
  @Mapping(target = "type", constant = "Credit/Debit Card")
  @Mapping(target = "category", source = "thisAccount.kind")
  @Mapping(target = "bookingDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'", source = "details.posted")
  @Mapping(target = "valueDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'", source = "details.completed")
  @Mapping(target = "transactionAmountCurrency.amount", source = "details.newBalance.amount")
  @Mapping(target = "transactionAmountCurrency.currencyCode", constant = "KES")
  @Mapping(target = "instructedAmountCurrency.amount", source = "details.value.amount")
  @Mapping(target = "instructedAmountCurrency.currencyCode", constant = "KES")
  @Mapping(target = "currencyExchangeRate", constant = "1")
  @Mapping(target = "counterPartyName", source = "thisAccount.kind")
  @Mapping(target = "counterPartyAccountNumber", source = "thisAccount.IBAN", qualifiedByName = "map")
  @Mapping(target = "counterPartyBIC", source = "thisAccount.bank.nationalIdentifier", defaultValue = "ING")
  @Mapping(target = "counterPartyCountry", constant = "KE")
  @Mapping(target = "counterPartyBankName", source = "thisAccount.bank.name")
  @Mapping(target = "creditorId", source = "otherAccount.holder.name")
  @Mapping(target = "mandateReference", source = "details.type")
  @Mapping(target = "billingStatus", constant = "BILLED")
  @Mapping(target = "checkSerialNumber", constant = "1")
  @Mapping(target = "runningBalance", constant = "1")
  @Mapping(target = "creditDebitIndicator", source = "details.value.amount", qualifiedByName = "creditDebitIndicator")
  TransactionsPostRequestBody map(Transaction transaction);

  @Named("creditDebitIndicator")
  default TransactionsPostRequestBody.CreditDebitIndicator mapCreditDebitIndicator(String amount) {
    BigDecimal value = new BigDecimal(amount);
    if (value.compareTo(BigDecimal.ZERO) < 0) {
      return TransactionsPostRequestBody.CreditDebitIndicator.DBIT;
    } else {
      return TransactionsPostRequestBody.CreditDebitIndicator.CRDT;
    }
  }

  @Named("instructedAmountConverter")
  default BigDecimal convert(Object amount) {
    return new BigDecimal(amount.toString());
  }

  @Named("map")
  default String map(Object value) {
    if (Objects.isNull(value)) {
      return null;
    } else {
      return value.toString();
    }
  }
}
