package apps.app_myfactory.material;

import apps.app_myfactory.employe.Employe;

import java.util.List;

public class MaterialServicesImpl implements MaterialServices{
    private final MaterialDao materialDao;

    public MaterialServicesImpl() {
        this.materialDao = new MaterialDaoImpl();
    }

    @Override
    public void createMaterial(Material material) {
        Material m = materialDao.getMaterialByIdDao(material.getId());
        if (m == null) {
            materialDao.saveMaterialDao(material);
        }
    }

    @Override
    public void deleteMaterial(Long id) {
        Material material = materialDao.getMaterialByIdDao(id);
        if (material != null) {
            materialDao.deleteMaterialDao(id);
            System.out.println("Material with id: " + id + " deleted successfully.");
        }else {
            System.out.println("Material with id: " + id + " does not exist.");
        }
    }

    @Override
    public void updateMaterial(Long id, Material newMaterial) {
        Material material = materialDao.getMaterialByIdDao(id);
        if(material != null){
            material.setItemName(newMaterial.getItemName());
            material.setQuantity(newMaterial.getQuantity());
            material.setUnit(newMaterial.getUnit());
            materialDao.saveMaterialDao(material);
            System.out.println("Employe with id: " + id + " updated successfully.");
        }else{
            System.out.println("Employe with id: " + id + " does not exist.");
        }
    }

    @Override
    public Material getMaterialById(Long id) {
        return materialDao.getMaterialByIdDao(id);
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialDao.getAllMaterialsDao();
    }
}
