package com.neosoft.demospofity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.bean.AlbumBean;
import com.neosoft.demospofity.service.AlbumService;
import com.neosoft.demospofity.service.LibraryService;
import com.neosoft.demospofity.service.SearchService;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value="/demospotify/")
public class LibraryController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private LibraryService libraryService;
	
	@GetMapping(value="/library/add/{idAlbumSpotify}")
	@ResponseBody
	public boolean addAlbumToLibrary(@PathVariable("idAlbumSpotify") String idAlbumSpotify){
		libraryService.addAlbumToLibrary(idAlbumSpotify);
		return true;
	}
	
	@GetMapping(value="/library/delete/{idAlbumSpotify}")
	@ResponseBody
	public boolean deleteAlbumFromLibrary(@PathVariable("idAlbumSpotify") String idAlbumSpotify){
		libraryService.deleteAlbumFromLibrary(idAlbumSpotify);
		return true;
	}
	
	@GetMapping(value="/library")
	@ResponseBody
	public List<AlbumBean> getAllAlbumsFromLibrary(){
		List<AlbumBean> albums = libraryService.getAllAlbumsFromLibrary();
		return albums;
	}
	
	@GetMapping(value="/library/addOrRemoveFavoris/{idAlbumSpotify}/{favoris}")
	@ResponseBody
	public boolean addOrRemoveFavoris(@PathVariable("idAlbumSpotify") String idAlbumSpotify, @PathVariable("favoris") boolean favoris){
		libraryService.addOrRemoveFavoris(idAlbumSpotify, favoris);
		return true;
	}
	
	@GetMapping(value="/library/addTag/{idAlbumSpotify}/{tagAdd}")
	@ResponseBody
	public boolean addTag(@PathVariable("idAlbumSpotify") String idAlbumSpotify, @PathVariable("tagAdd") String tagAdd){
		albumService.addTagToAlbum(idAlbumSpotify, tagAdd);
		return true;
	}
}