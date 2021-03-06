package de.hybris.telcotrail.facades.product.converters.populator;

import com.epam.training.model.AdditionalInfoModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.telcotrail.facades.data.AdditionalInfoData;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;

public class AdditionalInfoPopulator<SOURCE extends ProductModel, TARGET extends ProductData> implements Populator<ProductModel, ProductData> {
    private Converter<AdditionalInfoModel, AdditionalInfoData> additionalInfoConverter;


    protected Converter<AdditionalInfoModel, AdditionalInfoData> getAdditionalInfoConverter() {
        return additionalInfoConverter;
    }

    @Required
    public void setAdditionalInfoConverter(final Converter<AdditionalInfoModel, AdditionalInfoData> additionalInfoConverter) {
        this.additionalInfoConverter = additionalInfoConverter;
    }

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productModel.setAdditionalInfos(Collections.singletonList(new AdditionalInfoModel()));

        productData.setAdditionalInfos(Converters.convertAll(productModel.getAdditionalInfos(), getAdditionalInfoConverter()));
    }
}