package com.example.Ecommerce.Controller;
import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Repository.ProductPictureRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Services.ProductPicture.IProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("productpicture")
public class ProductPictureController {
    @Autowired
    IProductPictureService iProductPictureService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/byid/{idProductpicture}")
    public ResponseEntity<byte[]> getProductpicture(@PathVariable Long idProductpicture) {
        Optional<Productpicture> productpicture = iProductPictureService.getProductpictureById(idProductpicture);
        // if (!productpicture) {Use isEmpty() instead of checking for null
        //  return ResponseEntity.notFound().build();
        // }

        try {
            Path imagePath = Paths.get(productpicture.get().getPath());
            byte[] imageBytes = Files.readAllBytes(imagePath);

            // Set appropriate headers for the image response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust the content type based on the image type

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{idProducts}")
    public List<Optional<Productpicture>> findByProduct_IdProducts(@PathVariable Long idProducts) {
        return iProductPictureService.findByProduct_IdProducts(idProducts);
    }
    @PostMapping("/product/{idProducts}")
    public Productpicture create(@PathVariable Long idProducts, @RequestParam MultipartFile file) {
        try {
            if (file.isEmpty()) {
                System.out.println("No picture selected for upload.");
                return null;
            }

            String filename = file.getOriginalFilename();
            String extension = filename.substring(filename.lastIndexOf(".") + 1);
            String extensionName = filename.substring(0, filename.lastIndexOf("."));
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            String baseDirectory = "productpicture";
            File directory = new File(baseDirectory);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Generate a unique filename to avoid conflicts
            String uniqueFilename = extensionName + "_" + System.currentTimeMillis() + "." + extension;
            Path path = Paths.get(baseDirectory, uniqueFilename);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copy Success");

            if (extension.equals("jpg") || extension.equals("png") || extension.equals("svg")) {
                Product product = productRepository.findById(idProducts).orElse(null);
                if (product == null) {
                    System.out.println("PRODUCT DOES NOT EXIST");
                    return null;
                }

                String pictureName = extensionName + "_" + file.getSize() + "KO";
                String picturePath = "productpicture/" + uniqueFilename; // Relative path

                String createdAtPicture = dateTime.format(formatter);

                Productpicture productpicture = new Productpicture();
                productpicture.setNamePicture(pictureName);
                productpicture.setPath(picturePath);
                productpicture.setSizePicture(file.getSize());
                productpicture.setCreatedatPicture(createdAtPicture);
                productpicture.setProduct(product);

                System.out.println("SAVE PICTURE SUCCESSFULLY");
                return iProductPictureService.create(productpicture);
            } else {
                System.out.println("This file is unsupported.");
            }
        } catch (IOException e) {
            System.out.println("Failed to upload the picture.");
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping()
    public List<Productpicture> getAll() {
        return iProductPictureService.GetAll();
    }

    @GetMapping(value = "/{id}/preview", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity preview(@PathVariable("id") Long id) throws IOException {
        Productpicture productpicture = iProductPictureService.findbyid(id);
        Path path = Paths.get(productpicture.getPath());
        byte[] img = Files.readAllBytes(path);

        return ResponseEntity.ok(img);
    }

    @GetMapping("CountPictures/{idProducts}")
    public long countByProduct_IdProducts (@PathVariable Long idProducts){
       Long productpicture = iProductPictureService.countByProduct_IdProducts(idProducts);
       return productpicture;
    }

    @PutMapping("/{idProductpicture}")
    public Productpicture update(@PathVariable Long idProductpicture,@RequestBody Productpicture productpicture){
        Productpicture updateproductpicture=iProductPictureService.Update(idProductpicture,productpicture);
        if (updateproductpicture!=null){
            return ResponseEntity.ok(updateproductpicture).getBody();
        }else {
            return null;
        }
    }
    @DeleteMapping("/{idProductpicture}")
    public String deleteProductPicutre(@PathVariable Long idProductpicture){
        iProductPictureService.deleteProductPicture(idProductpicture);
        return idProductpicture+": Deleted";
    }

}
