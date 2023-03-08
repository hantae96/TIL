package inheritance05;

public class MemberServiceImpl implements IMemberService{
    /*
	 MemberMain : 사용자 입력 값을 전달받아 MemberServiceImpl 안 Method 호출
	 MemberServiceImpl
	 : MemberMain에서 전달한 데이터를 받아 데이터검증 및 MemberDaoImpl Method호출
	 : 데이터 검증은 사용자 입력 값에 따라 등록/미등록 출력
	 MemberDaoImpl : 데이터 저장소 관리(Create, Read, Update, Delete)
	 */

    @Override
    public void insert(String email, String name, String mobile) {

    }

    @Override
    public void selectEmail(String email) {

    }

    @Override
    public void selectAll() {

    }

    @Override
    public void update(String email, String name, String mobile) {

    }

    @Override
    public void delete(String email) {

    }

}
