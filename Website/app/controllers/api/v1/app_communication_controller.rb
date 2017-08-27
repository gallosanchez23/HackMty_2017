class Api::V1::AppCommunicationController < ApplicationController
	require 'json'

	def show
		json_data = JSON.parse(params[:json])
		logger.info('json information: ' + json_data)
		respond_to do |format|
			format.json{
      	bars_code = json_data['product']['bars_code']
      	@product = Product.find_by(bars_code: bars_code)
				json_response(@product)
				#logger.info(@product.inspect)
			}
    end
	end
end
