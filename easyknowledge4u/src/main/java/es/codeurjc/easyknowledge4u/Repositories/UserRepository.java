

package es.codeurjc.easyknowledge4u.Repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.easyknowledge4u.Models.User;

@CacheConfig(cacheNames="cache")
public interface UserRepository extends JpaRepository<User, Long> {
	

	User findByName(String name);
	
	@CacheEvict(allEntries=true)
	User save(User usuario);
}


