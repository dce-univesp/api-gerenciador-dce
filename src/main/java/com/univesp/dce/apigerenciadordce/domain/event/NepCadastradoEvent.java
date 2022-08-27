package com.univesp.dce.apigerenciadordce.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.univesp.dce.apigerenciadordce.domain.model.Nep;

@Getter
@AllArgsConstructor
public class NepCadastradoEvent {
	private Nep nep;
}
