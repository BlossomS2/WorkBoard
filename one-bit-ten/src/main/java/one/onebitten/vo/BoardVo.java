package one.onebitten.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class BoardVo {
	private int board_num;
    private String board_title;
    private String board_day;
    private String board_writer;
}