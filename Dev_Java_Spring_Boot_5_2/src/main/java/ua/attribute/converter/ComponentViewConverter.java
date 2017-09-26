package ua.attribute.converter;

import ua.model.view.ComponentView;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class ComponentViewConverter implements Converter<ComponentView, String>{

	@Override
	public String convert(ComponentView source) {
		return source.getAmount()+" "+source.getMs()+" "+source.getIngredient();
	}

}
