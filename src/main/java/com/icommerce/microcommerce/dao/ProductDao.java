package com.icommerce.microcommerce.dao;

import com.icommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    // C'est la seule méthode utilsé dans le controlleur et qui n'est pas hérité des focntion déjà prédénies par springJPA(finAll, save,..)
    // le nom normé de cette méthode permet à springJPA d'inmplémenter cette méthode à notre place sur la colonne @Id(findBy"Id")
    Product findById(int id);

    List<Product> findByPrix(int prixLimit);

    List<Product> findByPrixGreaterThan(int prixLimit);

    /*
    @Query("SELECT id, nom, prix FROM Product p WHERE p.prix < :prixLimit")
    List<Product>  chercherUnProduitPasCher(@Param("prixLimit") int prix);
     */
}
