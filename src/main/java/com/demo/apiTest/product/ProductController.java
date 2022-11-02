package com.demo.apiTest.product;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "save product data", notes = "save product data using productDTO, all columns are nullable")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/save")
    public Product save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @ApiOperation(value = "find by id", notes = "find the data using id parameter")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @ApiImplicitParam(name = "id", value = "Unique key", required = true, dataType = "Long", paramType = "query", defaultValue = "None", example = "1")
    @GetMapping("/find_id")
    public ProductDTO findById(@RequestParam("id") Long id) {
        return productService.findById(id);
    }

    @ApiOperation(value = "find by id", notes = "find the data using id parameter")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "page number you want to see", required = false, dataType = "Integer", paramType = "query", defaultValue = "0", example = "0"),
            @ApiImplicitParam(name = "pageSize", value = "number of data per page", required = false, dataType = "Integer", paramType = "query", defaultValue = "10", example = "10"),
            @ApiImplicitParam(name = "sortBy", value = "data which you want to sort by", required = false, dataType = "String", paramType = "query", defaultValue = "id", example = "id")
    })
    @GetMapping("/find_all")
    public Page<ProductDTO> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return productService.findAll(pageable);
    }

}
