#sample usage
- repository
   **public interface RepositoryName extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {}**
- service
  **public PageResponseDTO<T> filterUsers(PageRequestDTO request) {
  Pageable pageable = PageRequest.of(request.getPage(), request.getSize(),
  Sort.by(request.getDirection(), request.getSortBy()));
        FilterSpecification<User> specBuilder = new FilterSpecification<>();
        var spec = specBuilder.build(request.getFilter());
        Page<User> page = userRepository.findAll(spec, pageable);
        Page<UserDTO> dtoPage = page.map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge()));
        return new PageResponseDTO<>(dtoPage);
  }**
