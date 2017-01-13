package be.vdab.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.htm")
public class JPAFilter implements Filter {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("allesVoorDeKeuken");
	private static final ThreadLocal<EntityManager> entityManager = new ThreadLocal<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// geen code nodig hier
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		entityManager.set(entityManagerFactory.createEntityManager());
		try {
			request.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		} finally {
			entityManager.get().close();
			entityManager.remove();
		}

	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}

	public static EntityManager getEntitymanager() {
		return entityManager.get();
	}
}
