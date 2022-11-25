package one.onebitten.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVo {
	private int board_num;
    private String board_title;
    private String board_day;
    private String board_writer;
    private String board_text;
}