package com.designCenter.designCenter.service.impl;

import com.designCenter.designCenter.dto.packs.PackageReqDto;
import com.designCenter.designCenter.entity.Customer;
import com.designCenter.designCenter.entity.Package;
import com.designCenter.designCenter.enums.ActiveStatus;
import com.designCenter.designCenter.enums.Category;
import com.designCenter.designCenter.repository.CustomerRepository;
import com.designCenter.designCenter.repository.PackageRepository;
import com.designCenter.designCenter.service.PackageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public String savePackageDetail(PackageReqDto packageReqDto) {
        Long senderId;
        Long receiverId;
        log.info("Find Sender in database by NIC{}",packageReqDto.getSender().getNic());
        Customer sendCustomer = customerRepository.findCustomerByNic(packageReqDto.getSender().getNic());
        if(sendCustomer == null){
            sendCustomer = Customer.builder()
                    .nic(packageReqDto.getSender().getNic())
                    .name(packageReqDto.getSender().getName())
                    .address(packageReqDto.getSender().getAddress())
                    .email(packageReqDto.getSender().getEmail())
                    .mobile(packageReqDto.getSender().getMobile())
                    .build();
            Customer savedCustomer = customerRepository.save(sendCustomer);
            senderId = savedCustomer.getId();
        }else{
            senderId = sendCustomer.getId();
        }
        log.info("Find Receiver in database by NIC{}",packageReqDto.getSender().getNic());
        Customer receiveCustomer = customerRepository.findCustomerByNic(packageReqDto.getReceiver().getNic());
        if(receiveCustomer == null){
            receiveCustomer = Customer.builder()
                    .nic(packageReqDto.getReceiver().getNic())
                    .name(packageReqDto.getReceiver().getName())
                    .address(packageReqDto.getReceiver().getAddress())
                    .email(packageReqDto.getReceiver().getEmail())
                    .mobile(packageReqDto.getReceiver().getMobile())
                    .build();
            Customer savedCustomer = customerRepository.save(receiveCustomer);
            receiverId = savedCustomer.getId();
        }else{
            receiverId = receiveCustomer.getId();
        }

        log.info("Getting package details for save.");
        Package tempPackage = Package.builder()
                .description(packageReqDto.getDescription())
                .weight(packageReqDto.getWeight())
                .width(packageReqDto.getWidth())
                .height(packageReqDto.getHeight())
                .length(packageReqDto.getLength())
                .startHub(packageReqDto.getStartHub())
                .finalHub(packageReqDto.getFinalHub())
                .price(packageReqDto.getPrice())
                .category(packageReqDto.getCategory())
                .startDate(new Date())
                .updated(new Date())
                .status(ActiveStatus.HANDED_OVER)
                .packageCode(UUID.randomUUID().toString().substring(0, 10))
                .sender(senderId)
                .receiver(receiverId)
                .build();

        Package savedPackage = packageRepository.save(tempPackage);

        return savedPackage.getPackageCode();
    }
}
