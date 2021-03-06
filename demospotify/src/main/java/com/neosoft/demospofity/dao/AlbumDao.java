package com.neosoft.demospofity.dao;

import com.neosoft.demospofity.dao.base.BaseDao;
import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.Library;

public interface AlbumDao extends BaseDao<Album>{

	Album findAlbumByIdSpotify(String idAlbumSpotify);
}
