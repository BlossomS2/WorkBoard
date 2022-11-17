package one.onebitten.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class UserVo {
	private String user_id;
    private String user_name;
    private String user_passwd;
    private String user_email;
    private int user_auth;

}
