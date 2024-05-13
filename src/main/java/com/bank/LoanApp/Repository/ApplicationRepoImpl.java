/*
 * package com.bank.LoanApp.Repository;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * import java.util.function.Function;
 * 
 * import org.springframework.data.domain.Example; import
 * org.springframework.data.domain.Page; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.data.domain.Sort; import
 * org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
 * import org.springframework.stereotype.Repository;
 * 
 * import com.bank.LoanApp.model.Application; import
 * com.bank.LoanApp.model.Customer;
 * 
 * @Repository public class ApplicationRepoImpl implements ApplicationRepo{
 * 
 * private List<Application> Alist = new ArrayList<>();
 * 
 * @Override public List<Application> getAllApplication() {
 * 
 * 
 * 
 * Alist.add(new Application("A",1L, 001L, 2000000, "Car Loan", 8.7, 6,
 * "Approval Pending" )); Alist.add(new Application("A21",2L, 001L,
 * 250000,"Personaal loan",8.7, 6,"Verification IN Progress")); Alist.add(new
 * Application("A22", 3L, 001L, 1000000,"Housing loan" ,12.2, 25,"Submited"));
 * Alist.add(new Application("A23", 5L, 001L, 1500000,"Personal Loan", 7,10,
 * "Rejected")); Alist.add(new Application("A24", 4L, 001L,
 * 5500000,"Housing loan", 9.2, 25, "Approved"));
 * 
 * return Alist; }
 * 
 * @Override public void save(Application application) { Alist.add(application);
 * 
 * }
 * 
 * @Override public void flush() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public <S extends Application> S saveAndFlush(S entity) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> List<S> saveAllAndFlush(Iterable<S>
 * entities) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public void deleteAllInBatch(Iterable<Application> entities) { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAllByIdInBatch(Iterable<String> ids) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAllInBatch() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public Application getOne(String id) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Application getById(String id) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Application getReferenceById(String id) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> List<S> findAll(Example<S> example)
 * { // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> List<S> findAll(Example<S> example,
 * Sort sort) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> List<S> saveAll(Iterable<S>
 * entities) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public List<Application> findAll() { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public List<Application> findAllById(Iterable<String> ids) { //
 * TODO Auto-generated method stub return null; }
 * 
 * @Override public Optional<Application> findById(String id) { // TODO
 * Auto-generated method stub return Optional.empty(); }
 * 
 * @Override public boolean existsById(String id) { // TODO Auto-generated
 * method stub return false; }
 * 
 * @Override public long count() { // TODO Auto-generated method stub return 0;
 * }
 * 
 * @Override public void deleteById(String id) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void delete(Application entity) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void deleteAllById(Iterable<? extends String> ids) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll(Iterable<? extends Application> entities) {
 * // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public List<Application> findAll(Sort sort) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public Page<Application> findAll(Pageable pageable) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> Optional<S> findOne(Example<S>
 * example) { // TODO Auto-generated method stub return Optional.empty(); }
 * 
 * @Override public <S extends Application> Page<S> findAll(Example<S> example,
 * Pageable pageable) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Application> long count(Example<S> example) { //
 * TODO Auto-generated method stub return 0; }
 * 
 * @Override public <S extends Application> boolean exists(Example<S> example) {
 * // TODO Auto-generated method stub return false; }
 * 
 * @Override public <S extends Application, R> R findBy(Example<S> example,
 * Function<FetchableFluentQuery<S>, R> queryFunction) { // TODO Auto-generated
 * method stub return null; }
 * 
 * }
 */