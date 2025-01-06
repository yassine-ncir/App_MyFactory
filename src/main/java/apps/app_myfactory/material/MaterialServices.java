package apps.app_myfactory.material;

import apps.app_myfactory.employe.Employe;

import java.sql.SQLException;
import java.util.List;

public interface MaterialServices {
    void createMaterial(Material material);
    void deleteMaterial(Long id) ;
    void updateMaterial(Long id, Material newMaterial) ;
    Material getMaterialById(Long id) ;
    List<Material> getAllMaterials();
}
