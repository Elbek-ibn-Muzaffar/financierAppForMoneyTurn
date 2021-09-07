package com.example.financier.controller;

import com.example.financier.domains.MoneySenderEntity;
import com.example.financier.payload.response.ConsumerDtos;
import com.example.financier.payload.response.SenderDto;
import com.example.financier.payload.request.SenderDtoReq;
import com.example.financier.services.ConsumerServiceContract;
import com.example.financier.services.SenderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sendMoney")
public class SenderResource {

    @Autowired
    private SenderService senderService;

    @Autowired
    private ConsumerServiceContract consumerServiceContract;



    //Barcha Transferlarni chiqarish
    @ApiOperation("Barcha transferlarni chiqarib beradi")
    @GetMapping("/getAllTransfer")
    public ResponseEntity getAllTransfers()
    {
        List<MoneySenderEntity> moneySenderEntities=senderService.getAllTransfers();
        return ResponseEntity.ok(moneySenderEntities);
    }

    //Transferni bazaga saqlash
    @ApiOperation("Transferni bazaga saqlaydi")
    @PostMapping("/saveTransfer")
    public ResponseEntity saveTransfer(@RequestBody SenderDtoReq senderDtoReq)
    {
        SenderDto senderDto=senderService.saveTransfer(senderDtoReq);
        return ResponseEntity.ok(senderDto);
    }

    //Transferni yangilash
    @ApiOperation("Transferni yangilash")
    @PutMapping("/updateTransfer")
    public ResponseEntity updateTransfer(@RequestParam long id, @RequestParam BigDecimal amount)
    {
        SenderDto senderDto=senderService.updateAmount(id, amount);
        return ResponseEntity.ok(senderDto);
    }

    //Transferni o'chirish
    @DeleteMapping("/deletteTransfer/{id}")
    public ResponseEntity deletteTransfer(@PathVariable long id)
    {
        String response=senderService.deletteTransfer(id);
        return ResponseEntity.ok(response);
    }

    //Barcha jo'natilgan pullar miqdori
    @ApiOperation("barcha jo'natilgan pullarni miqdorini chiqaradi")
    @GetMapping("/getTotalSumm")
    public ResponseEntity getTotalSumm()
    {
        BigDecimal Summ=senderService.getTotalMoney();
        return ResponseEntity.ok(Summ);
    }

    //Barcha harajatlarni chiqarish
    @ApiOperation("Baarcha Harajatlarni chiqarish")
    @GetMapping("/getAllCost")
    public List<ConsumerDtos> getAllCost()
    {
        return consumerServiceContract.getAllCosts();
    }


}
