package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/373006
 * @author Deep
 *
 */
public class FavoriteGenres {

	public static Map<String, List<String>> favGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		
		Map<String, List<String>> result = new HashMap<>();
		Map<String, String> songToGenre = new HashMap<>();
		
		for(String genre : genreMap.keySet()) {
			List<String> songs = genreMap.get(genre);
			for(String song : songs) {
				songToGenre.put(song, genre);
			}
		}
		
		Map<String, Map<String, Integer>> userGenreCount = new HashMap<>();
		for(String user : userMap.keySet()) {
			if(!userGenreCount.containsKey(user)) {
				userGenreCount.put(user, new HashMap<>());
			}
			List<String> songs = userMap.get(user);
			for(String song : songs) {
				String genre = songToGenre.get(song);
				int count = userGenreCount.get(user).getOrDefault(genre, 0) + 1;
				userGenreCount.get(user).put(genre, count);
			}
		}
		
		for(String user : userGenreCount.keySet()) {
			if(!result.containsKey(user)) {
				result.put(user, new ArrayList<>());
			}
			Map<String, Integer> pair = userGenreCount.get(user);
			int max = 0;
			List<String> favGenre = new ArrayList<>();
			for(String genre : pair.keySet()) {
				if(favGenre.size() == 0) {
					favGenre.add(genre);
					max = pair.get(genre);
				} else if(pair.get(genre) > max) {
					favGenre.clear();
					favGenre.add(genre);
					max = pair.get(genre);
				} else if(pair.get(genre) == max) {
					favGenre.add(genre);
				}
			}
			result.put(user, favGenre);
 		}
		return result;
	}
	
	public static void main(String[] args) {

		Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
		List<String> list2 = Arrays.asList("song5", "song6", "song7");
		userMap.put("Lia,", new ArrayList<String>());
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();
		List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		genreMap.put("Rock", list3);
		genreMap.put("Dubstep", list4);
		genreMap.put("Techno", list5);
		genreMap.put("Pop", list6);
		genreMap.put("Jazz", list7);

		System.out.println(favGenres(userMap, genreMap));
	}

}
