package com.eobrazovanje.university.mapper;

import com.eobrazovanje.university.entity.Transaction;
import com.eobrazovanje.university.mapper.dto.TransactionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TransactionDTO convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    public Set<TransactionDTO> convertToDtos(Page<Transaction> transactionPage) {
        return transactionPage.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    public Transaction convertToEntity(TransactionDTO transactionDTO) {
        return modelMapper.map(transactionDTO, Transaction.class);
    }

    public Set<Transaction> convertToEntities(Collection<TransactionDTO> transactionDTOS) {
        return transactionDTOS
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toSet());
    }

}
