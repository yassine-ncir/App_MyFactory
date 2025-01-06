package apps.app_myfactory.material;

import apps.app_myfactory.employe.Employe;

import java.util.List;

public interface MaterialDao {
    void saveMaterialDao(Material material) ;
    void deleteMaterialDao(Long id);
    Material getMaterialByIdDao(Long id);
    List<Material> getAllMaterialsDao();
}
