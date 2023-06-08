package com.example.Ecommerce.Controller;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Services.ProductPicture.IProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("productpicture")
public class ProductPictureController {
    @Autowired
    IProductPictureService iProductPictureService;
    @PostMapping()
    public Productpicture create(Productpicture productpicture,@RequestParam("file") MultipartFile file) throws Exception
    {
        byte[] fileContent = file.getBytes();
        Long sizeP=file.getSize();
        String getname = file.getName();
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);
        String extensionname = filename.substring(0, filename.lastIndexOf("."));
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//("dd-MM-yyyy HH:mm:ss")

        if (!file.isEmpty()) {
            try {
                //=====THIS FOR COPY PICTURE ON BACK UP
                //String Path_Directory ="../PicturesProducts";
                //Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
                //System.out.println("CopySucces");
                if (extension.equals("jpg") || extension.equals("png") ||extension.equals("svg") ){
                        System.out.println("extension :"+extension);
                        System.out.println("file.getOriginalFilename() : "+file.getOriginalFilename());
                        System.out.println("file.getName() :"+file.getName());
                        System.out.println("file.getContentType() :" +file.getContentType());
                        System.out.println("file.getsize() :"+file.getSize());
                        System.out.println(extensionname);

                        productpicture.setNamePicture(extensionname+"_"+sizeP);
                        productpicture.setPicture(fileContent);
                        productpicture.setSizePicture(sizeP);
                        productpicture.setCreatedatPicture(dateTime.format(formatter));

                        return iProductPictureService.create(productpicture);
                }
                else {
                    System.out.println("this file is insuportable");
                    return null;
                }
            } catch (Exception e) {
                System.out.println("Failed to upload the picture.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No picture selected for upload.");
        }
        return null;
    }


    @GetMapping()
    public List<Productpicture> getAll(){
        return iProductPictureService.GetAll();
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
