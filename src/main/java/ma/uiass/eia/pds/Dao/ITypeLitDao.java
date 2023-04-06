package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.TypeLit;

public interface ITypeLitDao extends IDao<TypeLit> {
    TypeLit getByCode(String codeTypelit);
}
